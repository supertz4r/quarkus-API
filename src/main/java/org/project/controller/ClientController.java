package org.project.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.StatusType;

import org.project.controller.dto.ClientDto;
import org.project.controller.form.ClientForm;
import org.project.model.Client;
import org.project.repository.ClientRepository;

@RequestScoped
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {
    
    @Inject
    private ClientRepository clientRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<ClientDto> listaClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return ClientDto.convert(clients);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response clientById(final @PathParam("id") long id) {
        Client client = clientRepository.findById(id).get();
        return Response.status(Response.Status.OK).entity(new ClientDto(client)).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(@Valid ClientForm form, UriBuilder uriBuilder) {
        Client client = form.convert();
        clientRepository.save(client);

        URI uri = uriBuilder.path("/client/{id}").build(client.getId());
        return Response.status((StatusType) UriBuilder.fromUri(uri)).entity(new ClientDto(client)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(final @PathParam("id") long id, @Valid ClientForm form) {
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            Client client = form.convert();
            return Response.status(Response.Status.OK).entity(new ClientDto(client)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response remover(final @PathParam("id") long id) {
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            clientRepository.deleteById(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
