/*
Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
Licensed under the Apache License, Version 2.0 (the "License").
You may not use this file except in compliance with the License.
A copy of the License is located at
    http://www.apache.org/licenses/LICENSE-2.0
or in the "license" file accompanying this file. This file is distributed
on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
express or implied. See the License for the specific language governing
permissions and limitations under the License.
*/

package com.amazonaws.services.neptune.metadata;

import com.amazonaws.services.neptune.graph.EdgesClient;
import com.amazonaws.services.neptune.graph.GraphClient;
import com.amazonaws.services.neptune.graph.NodesClient;
import com.amazonaws.services.neptune.io.EdgesWriterFactory;
import com.amazonaws.services.neptune.io.NodesWriterFactory;
import com.amazonaws.services.neptune.io.WriterFactory;
import com.amazonaws.services.neptune.io.Directories;
import org.apache.tinkerpop.gremlin.process.traversal.Path;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class MetadataTypes {
    public static final MetadataType<Map<?, Object>> Nodes = new MetadataType<Map<?, Object>>() {
        @Override
        public String name() {
            return "nodes";
        }

        @Override
        public GraphClient<Map<?, Object>> graphClient(GraphTraversalSource g) {
            return new NodesClient(g);
        }

        @Override
        public WriterFactory<Map<?, Object>> writerFactory(Directories directories) {
            return new NodesWriterFactory(directories);
        }
    };

    public static final MetadataType<Path> Edges = new MetadataType<Path>() {
        @Override
        public String name() {
            return "edges";
        }

        @Override
        public GraphClient<Path> graphClient(GraphTraversalSource g) {
            return new EdgesClient(g);
        }

        @Override
        public WriterFactory<Path> writerFactory(Directories directories) {
            return new EdgesWriterFactory(directories);
        }
    };

    public static Collection<MetadataType<?>> values() {
        return Arrays.asList(Nodes, Edges);
    }
}
