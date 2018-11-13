package com.systelab.patient.boundary;

import com.systelab.infrastructure.pagination.Page;
import com.systelab.patient.entity.Patient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("patients")
@RequestScoped
public class PatientsResource {

    @Operation(description = "Get all Patients", summary = "Get all Patients")
    @GET
    @Metered
    public Response getAllPatients(@DefaultValue("0") @QueryParam("page") int page, @DefaultValue("20") @QueryParam("size") int itemsPerPage) {
        try {
            Page<Patient> patients = new Page(new ArrayList<Patient>(), 0);

            return Response.ok().entity(new GenericEntity<Page<Patient>>(patients) {
            }).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Inject
    @ConfigProperty(name = "place", defaultValue = "World")
    private String place;

    @GET
    @Path("hello")
    public Response greet() {
        return Response.ok("Hello " + place + "! ...from Payara Micro").build();
    }

}
