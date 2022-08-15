package org.project.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.opentracing.Traced;
import org.project.controller.form.CategoriaForm;
import org.project.dao.CategoriaDao;
import org.project.model.Categoria;
import org.project.service.CategoriaService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class CategoriaController {
    
    @Inject
    CategoriaService service;

    @Inject
    CategoriaDao dao;

    @GET
    @Path("/list")
    @Operation(summary = "Listar Categorias ",
            description = "Retorna uma lista de categoria")
    @APIResponse(
            responseCode = "200",
            description = "Categoria",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class, type = SchemaType.ARRAY))})
    public Response listaCategorias() throws Exception {
        return Response.status(Response.Status.OK).entity(dao.buscaCategorias()).build();
    }

    @GET
    @Path("/{codigo}")
    @Operation(summary = "Busca Categoria por Codigo",
            description = "Retorna um categoria")
    @APIResponse(
            responseCode = "200",
            description = "Categoria",
            content = { @Content (mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))})
    public Response categoriaById(final @PathParam("codigo") long codigo) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.buscarCategoria(codigo)).build();
    }

    @POST
    @Operation(summary = "Incluir um categoria.",
            description = "Incluir um categoria")
    @APIResponse(
            responseCode = "201",
            description = "Categoria",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))})
    public Response cadastrar(@Valid CategoriaForm form) throws Exception {
        Categoria categoria = form.convert();

        return Response.status(Response.Status.CREATED).entity(service.inserirCategoria(categoria)).build();
    }

    @PUT
    @Path("/{codigo}")
    @Operation(summary = "Atualizar um Categoria",
            description = "Atualização de um categoria")
    @APIResponse(
            responseCode = "200",
            description = "Categoria",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))})
    public Response atualizar(final @PathParam("codigo") long codigo, @Valid CategoriaForm form) throws Exception {
        Categoria categoria = form.convert();
        return Response.status(Response.Status.OK).entity(service.atualizarCategoria(codigo, categoria)).build();
    }

    @DELETE
    @Path("/{codigo}")
    @Operation(summary = "Remove um categoria",
            description = "Remove um categoria pelo Codigo informado")
    @APIResponse(
            responseCode = "200",
            description = "Categoria",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))})
    public Response remover(final @PathParam("codigo") long codigo) throws Exception {
        return Response.status(Response.Status.OK).entity(dao.excluirCategoria(codigo)).build();
    }
}
