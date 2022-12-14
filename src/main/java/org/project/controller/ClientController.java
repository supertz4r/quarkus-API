package org.project.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.Content;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.opentracing.Traced;
import org.project.controller.dto.ClientDto;
import org.project.controller.form.ClientForm;
import org.project.model.Client;
import org.project.service.ClientService;
import org.project.dao.ClientDao;

@RequestScoped
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class ClientController {
    
    @Inject
    ClientService service;

    @Inject
    ClientDao dao;

    @GET
    @Path("/list")
    @Operation(summary = "Listar Clients ",
            description = "Retorna uma lista de client")
    @APIResponse(
            responseCode = "200",
            description = "Client",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class, type = SchemaType.ARRAY))})
    public Response listaClients() throws Exception {
        /* List<Client> clients = (List<Client>) dao.buscaClients();
        return ClientDto.convert(clients); */

        return Response.status(Response.Status.OK).entity(dao.buscaClients()).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Busca Client por ID",
            description = "Retorna um client")
    @APIResponse(
            responseCode = "200",
            description = "Client",
            content = { @Content (mediaType = "application/json",
                    schema = @Schema(implementation = Client.class))})
    public Response clientById(final @PathParam("id") long id) throws Exception {
        /* Client client = clientRepository.findById(id).get();
        return Response.status(Response.Status.OK).entity(new ClientDto(client)).build(); */
        return  Response.status(Response.Status.OK).entity(dao.buscarClient(id)).build();
    }

    @POST
    @Operation(summary = "Incluir um client.",
            description = "Incluir um client")
    @APIResponse(
            responseCode = "201",
            description = "Client",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class))})
    public Response cadastrar(@Valid ClientForm form) throws Exception {
        Client client = form.convert();
        //clientRepository.save(client);

        return Response.status(Response.Status.CREATED).entity(service.inserirClient(client)).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um Client",
            description = "Atualiza????o de um client")
    @APIResponse(
            responseCode = "200",
            description = "Client",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class))})
    public Response atualizar(final @PathParam("id") long id, @Valid ClientForm form) throws Exception {
        /* Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            Client client = form.convert();
            return Response.status(Response.Status.OK).entity(new ClientDto(client)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build(); */
        Client client = form.convert();
        return Response.status(Response.Status.OK).entity(service.atualizarClient(id, client)).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remove um client",
            description = "Remove um client pelo ID informado")
    @APIResponse(
            responseCode = "200",
            description = "Client",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class))})
    public Response remover(final @PathParam("id") long id) throws Exception {
        /* Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            clientRepository.deleteById(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build(); */
        return Response.status(Response.Status.OK).entity(dao.excluirClient(id)).build();
    }
}
