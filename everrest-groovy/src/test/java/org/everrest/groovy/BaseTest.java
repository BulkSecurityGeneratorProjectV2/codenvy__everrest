/**
 * Copyright (C) 2010 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.everrest.groovy;

import junit.framework.TestCase;

import org.everrest.core.impl.ProviderBinder;
import org.everrest.core.impl.RequestHandlerImpl;
import org.everrest.core.impl.ResourceBinderImpl;
import org.everrest.core.tools.DependencySupplierImpl;
import org.everrest.core.tools.ResourceLauncher;

/**
 * @author <a href="mailto:andrew00x@gmail.com">Andrey Parfonov</a>
 * @version $Id$
 */
public abstract class BaseTest extends TestCase
{
   protected ProviderBinder providers;

   protected ResourceBinderImpl resources;

   protected RequestHandlerImpl requestHandler;

   protected ResourceLauncher launcher;

   protected GroovyResourcePublisher groovyPublisher;

   protected DependencySupplierImpl dependencies;

   protected void setUp() throws Exception
   {
      this.resources = new ResourceBinderImpl();
      this.dependencies = new DependencySupplierImpl();
      this.requestHandler = new RequestHandlerImpl(resources, dependencies);
      this.providers = ProviderBinder.getInstance();
      this.launcher = new ResourceLauncher(requestHandler);
      this.groovyPublisher = new GroovyResourcePublisher(resources, dependencies);
   }

   @Override
   protected void tearDown() throws Exception
   {
      super.tearDown();
   }
}