/**
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
package a.b

@javax.ws.rs.Path("a")
class GroovyResource2 {
    private org.everrest.groovy.GroovyIoCInjectTest.Component1 component

    GroovyResource2(org.everrest.groovy.GroovyIoCInjectTest.Component1 component) {
        this.component = component
    }

    @javax.ws.rs.GET
    @javax.ws.rs.Path("b")
    def m0() { component.getName() }
}