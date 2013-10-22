/* Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.astonish.dropwizard.routing.migrations;

import com.astonish.dropwizard.routing.db.RoutingDatabaseConfiguration;
import com.codahale.dropwizard.Bundle;
import com.codahale.dropwizard.Configuration;
import com.codahale.dropwizard.setup.Bootstrap;
import com.codahale.dropwizard.setup.Environment;
import com.codahale.dropwizard.util.Generics;

/**
 * Routing migrations bundle.
 */
public abstract class RoutingMigrationsBundle<T extends Configuration> implements Bundle,
        RoutingDatabaseConfiguration<T> {
    @Override
    public final void initialize(Bootstrap<?> bootstrap) {
        final Class<T> klass = Generics.getTypeParameter(getClass(), Configuration.class);
        bootstrap.addCommand(new RoutingDbCommand<>(this, klass));
    }

    @Override
    public final void run(Environment environment) {
        // nothing doing
    }
}