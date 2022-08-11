package org.project.controller;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.project.controller.dto.ClientDto;
import org.project.controller.form.ClientForm;
import org.project.model.Client;
import org.project.repository.ClientRepository;

@RequestScoped
@Path("/client")
/* @Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced */
public class ClientController {
    
    @Inject
    private ClientRepository clientRepository;

    @GET
    @Path("/list")
    public List<ClientDto> listaClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return ClientDto.convert(clients);
    }

    public Response cadastrar(@Valid ClientForm form, UriBuilder uriBuilder) {
        Client client = form.convert();
        clientRepository.save(client);

        URI uri = uriBuilder.path("/client/{id}").build(client.getId());
        return Response.created(uri).build();
    }
}
