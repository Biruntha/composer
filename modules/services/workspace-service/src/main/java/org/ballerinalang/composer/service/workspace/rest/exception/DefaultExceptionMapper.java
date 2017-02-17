/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/

package org.ballerinalang.composer.service.workspace.rest.exception;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Exception mapper class for all exceptions.
 */
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionMapper.class);
    
    /**
     * @inheritDoc
     */
    @Override
    public Response toResponse(Exception exception) {
        logger.error("error: failed to generate JSON data model for ballerina file", exception.getMessage());
        JsonObject entity = new JsonObject();
        entity.addProperty("Error", "Error Generating JSON Model");
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(entity)
                .header("Access-Control-Allow-Origin", '*')
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}