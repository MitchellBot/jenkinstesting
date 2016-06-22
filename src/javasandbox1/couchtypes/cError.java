/*
 * Copyright (C) 2016 Yaakov.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package javasandbox1.couchtypes;
import com.couchbase.client.java.document.*;
import com.couchbase.client.java.document.json.JsonObject;

/**
 *
 * @author Yaakov
 */
public class cError extends cMessage {
 
    String exception;
    String details;
    
    public cError()
    {
        type = messagetype.error.toString();
    }
    
    public void SetErrorDetails(String source, String exception, String details)
    {
        this.details = details;
        this.source = source;
        this.exception = exception;
    }
    
    public JsonDocument GetErrorAsJsonDoc()
    {
        JsonObject jobj = JsonObject.empty();
        
        jobj.put("Id",this.id)
                .put("Source",this.source)
                .put("Exception", this.exception)
                .put("Details", this.details)
                .put("Timestmap", this.timestamp)
                .put("Type", this.type)
                .put("Acknowledged", this.acknowledged)
                .put("Acknowledged By", this.acnowledgedby)
                .put("Archived", this.archived);
        
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.id);
                
        JsonDocument jdoc = JsonDocument.create(sb.toString(), jobj);
        
        return jdoc;
    }
}
