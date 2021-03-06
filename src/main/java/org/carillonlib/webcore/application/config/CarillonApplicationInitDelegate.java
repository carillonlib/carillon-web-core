/*
 * Copyright (c) 2012, Infinity Learning Solutions, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with
 * or without modification, are permitted provided that the
 * following conditions are met:
 *
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer.
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *     * Neither the name of Infinity Learning Solutions, Inc. nor
 *       the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific
 *       prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.carillonlib.webcore.application.config;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContextAware;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p>
 * Interface for classes which need to contribute to the servlet configuration
 * on startup and also need access to the Spring application context. When
 * starting up, the {@link CarillonWebApplicationInitializer} will find all
 * registered spring beans which implement this interface and call
 * {@code #onCarillonStartup(WebApplicationContext)}. The provided
 * {@link WebApplicationContext} object provides access to the
 * {@link ServletContext} so further servlet configuration can take place.
 * </p>
 * 
 * <p>
 * Note that implementing this to perform servlet configuration tasks is
 * strongly encouraged as opposed to implementing
 * {@link WebApplicationInitializer} and {@link ApplicationContextAware} because
 * the methods on those interfaces may be called too early before all beans have
 * been registered and configured by the Spring container.
 * </p>
 * 
 * <p>
 * If you will be performing servlet configuration that does not need access to
 * the application context and will be located in a JAR file instead of the main
 * application code, you may prefer to implement
 * {@link WebApplicationInitializer} or {@link ServletContainerInitializer}
 * directly depending on your situation.
 * 
 * @author eric
 * 
 */
public interface CarillonApplicationInitDelegate {

	public void onCarillonStartup(WebApplicationContext webApplicationContext);

}
