/*
 * Copyright (c) 2012-2021 Codenvy, S.A.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 */
package org.everrest.core.impl.method;

import org.everrest.core.ApplicationContext;
import org.everrest.core.InitialProperties;
import org.everrest.core.impl.EnvironmentContext;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

/**
 * @author andrew00x
 */
public class ContextParameterResolver implements ParameterResolver<Context> {

    @Override
    public Object resolve(org.everrest.core.Parameter parameter, ApplicationContext context) throws Exception {
        Class<?> parameterClass = parameter.getParameterClass();
        if (parameterClass == HttpHeaders.class) {
            return context.getHttpHeaders();
        } else if (parameterClass == SecurityContext.class) {
            return context.getSecurityContext();
        } else if (parameterClass == Request.class) {
            return context.getRequest();
        } else if (parameterClass == UriInfo.class) {
            return context.getUriInfo();
        } else if (parameterClass == Providers.class) {
            return context.getProviders();
        } else if (parameterClass == Application.class) {
            return context.getApplication();
        } else if (parameterClass == InitialProperties.class) {
            return context.getInitialProperties();
        }
        return EnvironmentContext.getCurrent().get(parameter.getParameterClass());
    }
}
