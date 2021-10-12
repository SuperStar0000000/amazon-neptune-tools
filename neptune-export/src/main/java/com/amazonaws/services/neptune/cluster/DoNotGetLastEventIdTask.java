/*
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
Licensed under the Apache License, Version 2.0 (the "License").
You may not use this file except in compliance with the License.
A copy of the License is located at
    http://www.apache.org/licenses/LICENSE-2.0
or in the "license" file accompanying this file. This file is distributed
on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
express or implied. See the License for the specific language governing
permissions and limitations under the License.
*/

package com.amazonaws.services.neptune.cluster;

import com.amazonaws.services.neptune.io.CommandWriter;

import java.io.IOException;

public class DoNotGetLastEventIdTask implements GetLastEventIdStrategy {
    @Override
    public void saveLastEventId(String streamEndpointType) throws IOException {
        // Do nothing
    }

    @Override
    public void writeLastEventIdResourcePathAsMessage(CommandWriter writer) {
        // Do nothing
    }
}
