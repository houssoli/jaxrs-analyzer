/*
 * Copyright (C) 2015 Sebastian Daschner, sebastian-daschner.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sebastian_daschner.jaxrs_analyzer.analysis.project.methods.testclasses.resource.response;

import com.sebastian_daschner.jaxrs_analyzer.model.elements.Element;
import com.sebastian_daschner.jaxrs_analyzer.model.elements.HttpResponse;
import com.sebastian_daschner.jaxrs_analyzer.model.elements.JsonArray;
import com.sebastian_daschner.jaxrs_analyzer.model.elements.JsonObject;

import javax.json.Json;
import javax.json.JsonStructure;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;

public class TestClass38 {

    public Response method() {
        JsonStructure structure = Json.createArrayBuilder().add("duke").add(42).build();
        if ("".equals(""))
            structure = Json.createObjectBuilder().add("duke", 42).add("key", "value").build();
        return Response.ok(structure).build();
    }

    public static Set<HttpResponse> getResult() {
        final HttpResponse result = new HttpResponse();

        result.getStatuses().add(200);
//        result.getEntityTypes().add("javax.json.JsonStructure");
        // TODO expect several types
        result.getEntityTypes().add("javax.json.JsonArray");

        final JsonObject jsonObject = new JsonObject();
        jsonObject.getStructure().put("key", new Element("java.lang.String", "value"));
        jsonObject.getStructure().put("duke", new Element("java.lang.Integer", 42));

        final JsonArray jsonArray = new JsonArray();
        jsonArray.getElements().add(new Element("java.lang.String", "duke"));
        jsonArray.getElements().add(new Element("java.lang.Integer", 42));

        result.getInlineEntities().add(jsonObject);
        result.getInlineEntities().add(jsonArray);

        return Collections.singleton(result);
    }

}
