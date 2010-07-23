/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.datastore.neo4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.datastore.core.DatastoreConnectionFactory;
import org.springframework.util.Assert;

/**
 * Convenient factory for configuring Neo4J.
 *
 * @author Thomas Risberg
 * @since 1.0
 */
public class Neo4jConnectionFactory implements DatastoreConnectionFactory<GraphDatabaseService>, InitializingBean {

	/**
	 * Logger, available to subclasses.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	private GraphDatabaseService graphDatabaseService = null;

	public Neo4jConnectionFactory() {
		super();
	}
	
	public Neo4jConnectionFactory(GraphDatabaseService graphDatabaseService) {
		super();
		this.graphDatabaseService = graphDatabaseService;
	}	
	
	public void afterPropertiesSet() throws Exception {
		// apply defaults - convenient when used to configure for tests 
		// in an application context
		Assert.notNull(graphDatabaseService, "GraphDatabaseService must be set");
	}

	public GraphDatabaseService getConnection() {
		Assert.notNull(graphDatabaseService, "GraphDatabaseService must be set");
		return graphDatabaseService;
	}

}
