    NAME
            neptune-export.sh export-pg - Export property graph from Neptune to CSV
            or JSON
    
    SYNOPSIS
            neptune-export.sh export-pg
                    [ --alb-endpoint <applicationLoadBalancerEndpoint> ]
                    [ {-cn | --concurrency} <concurrency> ]
                    {-d | --dir} <directory> {-e | --endpoint} <endpoint>...
                    [ {-el | --edge-label} <edgeLabels>... ]
                    [ --exclude-type-definitions ] [ --format <format> ]
                    [ --lb-port <loadBalancerPort> ] [ --limit <limit> ]
                    [ --log-level <log level> ]
                    [ --max-content-length <maxContentLength> ]
                    [ {-nl | --node-label} <nodeLabels>... ]
                    [ --nlb-endpoint <networkLoadBalancerEndpoint> ]
                    [ {-o | --output} <output> ] [ {-p | --port} <port> ]
                    [ {-r | --range | --range-size} <rangeSize> ]
                    [ {-s | --scope} <scope> ] [ --sample ]
                    [ --sample-size <sampleSize> ] [ --serializer <serializer> ]
                    [ --skip <skip> ] [ {-t | --tag} <tag> ]
                    [ --tokens-only <tokensOnly> ] [ --use-iam-auth ] [ --use-ssl ]
    
    OPTIONS
            --alb-endpoint <applicationLoadBalancerEndpoint>
                Application load balancer endpoint (optional: use only if
                connecting to an IAM DB enabled Neptune cluster through an
                application load balancer (ALB) – see https://github.com/aws-samples/aws-dbs-refarch-graph/tree/master/src/connecting-using-a-load-balancer#connecting-to-amazon-neptune-from-clients-outside-the-neptune-vpc-using-aws-application-load-balancer)
    
                This option may occur a maximum of 1 times
    
    
                This option is part of the group 'load-balancer' from which only
                one option may be specified
    
    
            -cn <concurrency>, --concurrency <concurrency>
                Concurrency (optional)
    
                This option may occur a maximum of 1 times
    
    
            -d <directory>, --dir <directory>
                Root directory for output
    
                This option may occur a maximum of 1 times
    
    
                This options value must be a path to a directory. The provided path
                must be readable and writable.
    
    
            -e <endpoint>, --endpoint <endpoint>
                Neptune endpoint(s) – supply multiple instance endpoints if you
                want to load balance requests across a cluster
    
            -el <edgeLabels>, --edge-label <edgeLabels>
                Labels of edges to be exported (optional, default all labels)
    
            --exclude-type-definitions
                Exclude type definitions from column headers (optional, default
                'false')
    
                This option may occur a maximum of 1 times
    
    
            --format <format>
                Output format (optional, default 'csv')
    
                This options value is restricted to the following set of values:
                    csv
                    csvNoHeaders
                    json
    
                This option may occur a maximum of 1 times
    
    
            --lb-port <loadBalancerPort>
                Load balancer port (optional, default 80)
    
                This option may occur a maximum of 1 times
    
    
                This options value represents a port and must fall in one of the
                following port ranges: 1-1023, 1024-49151
    
    
            --limit <limit>
                Maximum number of items to export (optional)
    
                This option may occur a maximum of 1 times
    
    
            --log-level <log level>
                Log level (optional, default 'error')
    
                This options value is restricted to the following set of values:
                    trace
                    debug
                    info
                    warn
                    error
    
                This option may occur a maximum of 1 times
    
    
            --max-content-length <maxContentLength>
                Max content length (optional, default 65536)
    
                This option may occur a maximum of 1 times
    
    
            -nl <nodeLabels>, --node-label <nodeLabels>
                Labels of nodes to be exported (optional, default all labels)
    
            --nlb-endpoint <networkLoadBalancerEndpoint>
                Network load balancer endpoint (optional: use only if connecting to
                an IAM DB enabled Neptune cluster through a network load balancer
                (NLB) – see https://github.com/aws-samples/aws-dbs-refarch-graph/tree/master/src/connecting-using-a-load-balancer#connecting-to-amazon-neptune-from-clients-outside-the-neptune-vpc-using-aws-network-load-balancer)
    
                This option may occur a maximum of 1 times
    
    
                This option is part of the group 'load-balancer' from which only
                one option may be specified
    
    
            -o <output>, --output <output>
                Output target (optional, default 'file')
    
                This options value is restricted to the following set of values:
                    files
                    stdout
    
                This option may occur a maximum of 1 times
    
    
            -p <port>, --port <port>
                Neptune port (optional, default 8182)
    
                This option may occur a maximum of 1 times
    
    
                This options value represents a port and must fall in one of the
                following port ranges: 1-1023, 1024-49151
    
    
            -r <rangeSize>, --range <rangeSize>, --range-size <rangeSize>
                Number of items to fetch per request (optional)
    
                This option may occur a maximum of 1 times
    
    
            -s <scope>, --scope <scope>
                Scope (optional, default 'all')
    
                This options value is restricted to the following set of values:
                    all
                    nodes
                    edges
    
                This option may occur a maximum of 1 times
    
    
            --sample
                Select only a subset of nodes and edges when generating property
                metadata
    
                This option may occur a maximum of 1 times
    
    
            --sample-size <sampleSize>
                Property metadata sample size (optional, default 1000
    
                This option may occur a maximum of 1 times
    
    
            --serializer <serializer>
                Message serializer – either 'GRAPHBINARY_V1D0' or 'GRYO_V3D0'
                (optional, default 'GRAPHBINARY_V1D0')
    
                This options value is restricted to the following set of values:
                    GRAPHBINARY_V1D0
                    GRYO_V3D0
    
                This option may occur a maximum of 1 times
    
    
            --skip <skip>
                Number of items to skip (optional)
    
                This option may occur a maximum of 1 times
    
    
            -t <tag>, --tag <tag>
                Directory prefix (optional)
    
                This option may occur a maximum of 1 times
    
    
            --tokens-only <tokensOnly>
                Export tokens (~id, ~label) only (optional, default 'off')
    
                This options value is restricted to the following set of values:
                    off
                    nodes
                    edges
                    both
    
                This option may occur a maximum of 1 times
    
    
            --use-iam-auth
                Use IAM database authentication to authenticate to Neptune
                (remember to set SERVICE_REGION environment variable, and, if using
                a load balancer, set the --host-header option as well)
    
                This option may occur a maximum of 1 times
    
    
            --use-ssl
                Enables connectivity over SSL
    
                This option may occur a maximum of 1 times
    
    
    EXAMPLES
            bin/neptune-export.sh export-pg -e neptunedbcluster-xxxxxxxxxxxx.cluster-yyyyyyyyyyyy.us-east-1.neptune.amazonaws.com -d /home/ec2-user/output
    
                Export all data to the /home/ec2-user/output directory
    
            bin/neptune-export.sh export-pg -e neptunedbcluster-xxxxxxxxxxxx.cluster-yyyyyyyyyyyy.us-east-1.neptune.amazonaws.com -d /home/ec2-user/output --format json
    
                Export all data to the /home/ec2-user/output directory as JSON
    
            bin/neptune-export.sh export-pg -e neptunedbcluster-xxxxxxxxxxxx.cluster-yyyyyyyyyyyy.us-east-1.neptune.amazonaws.com -d /home/ec2-user/output -s nodes
    
                Export only nodes to the /home/ec2-user/output directory
    
            bin/neptune-export.sh export-pg -e neptunedbcluster-xxxxxxxxxxxx.cluster-yyyyyyyyyyyy.us-east-1.neptune.amazonaws.com -d /home/ec2-user/output -nl User -el FOLLOWS
    
                Export only User nodes and FOLLOWS relationships
    
            bin/neptune-export.sh export-pg -e neptunedbcluster-xxxxxxxxxxxx.cluster-yyyyyyyyyyyy.us-east-1.neptune.amazonaws.com -d /home/ec2-user/output -cn 2
    
                Parallel export using 2 threads
    
            bin/neptune-export.sh export-pg -e neptunedbcluster-xxxxxxxxxxxx.cluster-yyyyyyyyyyyy.us-east-1.neptune.amazonaws.com -d /home/ec2-user/output -cn 2 -r 1000
    
                Parallel export using 2 threads, with each thread processing
                batches of 1000 nodes or edges
    