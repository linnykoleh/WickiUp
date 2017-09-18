#### DynamoDB

![DynamoDB](../images/DynamoDB/dynamo-db-1.png)

- Quick facts about DynamoDB
    - Stored on SSD storage
    - Spread Across 3 geographically distinct data centers
    - Type of data consistency
        - Eventual Consistent Reads (Default)
            - Consistency across all copies of data is usually reached within a second. 
              Repeating a read after a short time should return the updated data (Best Read Performance)
        - Strongly Consistent Reads
            - A strongly consistent read returns a result that reflect all writes that 
              received a successful response prior to the read

- The basics         
    - Table
    - Items (Think a row of data in table)
    - Attributes (Think of a column of data in a table)

![DynamoDB](../images/DynamoDB/dynamo-db-2.png)

- Pricing
    - Provisioned Throughput Capacity
        - Write Throughput $0.0065 per hour for every 10 units
        - REad Throughput $0.0065 per hour for every 50 units
    - First 25 GB stored per month is free    
    - Storage costs of $0.25 GB per month there after

![DynamoDB](../images/DynamoDB/dynamo-db-3.png)

![DynamoDB](../images/DynamoDB/dynamo-db-4.png)

![DynamoDB](../images/DynamoDB/dynamo-db-5.png)

![DynamoDB](../images/DynamoDB/dynamo-db-6.png)

![DynamoDB](../images/DynamoDB/dynamo-db-7.png)

**Creating A DynamoDB Table**
      