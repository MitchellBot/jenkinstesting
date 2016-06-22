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
package javasandbox1;

import com.couchbase.client.java.*;
import com.couchbase.client.java.document.JsonDocument;
import javasandbox1.couchtypes.*;

/**
 *
 * @author Yaakov
 */
public class Couchcommit {
    
    private static Cluster mainCluster;
    private static Bucket mainBucket;

    private void KillIt()
    {
        mainBucket.close();
        mainCluster.disconnect();
    }
    
    private void Connect()
    {
        System.out.println("Testing cluster create...");

        mainCluster = CouchbaseCluster.create();
        
        System.out.println("Testing bucket create...");

        mainBucket = mainCluster.openBucket();
        
    }

    public void RunErrorMessageTest()
    {
        Connect();
        TestCommit();
        KillIt();
    }
        
    private void TestCommit()
    {
        cError emsg = new cError();
        
        emsg.SetErrorDetails("TestCommit", "You did not eat your meat", "You cannot have any pudding.");
        
        System.out.println("Adding jdoc to bucket");
        JsonDocument mresponse = mainBucket.upsert(emsg.GetErrorAsJsonDoc());
        
        System.out.println("JDoc Response from Bucket: " + mresponse.content());
        
    }
}