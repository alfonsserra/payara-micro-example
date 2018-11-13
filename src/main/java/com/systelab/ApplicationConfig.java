package com.systelab;

import com.systelab.patient.boundary.PatientsResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(PatientsResource.class);
        return resources;
    }
}
