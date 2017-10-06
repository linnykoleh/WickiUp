1. Question:

   If an application is storing hourly log files from thousands of instances from a 
   high traffic web site, which naming scheme would give optimal performance on S3?
   
  Answers:
   
- instanceID_log-HH-DD-MM-YYYY
- **HH-DD-MM-YYYY-log_instanceID**
- instanceID_log-YYYY-MM-DD-HH
- Sequential
- YYYY-MM-DD-HH-log_instanceID

 http://docs.aws.amazon.com/AmazonS3/latest/dev/request-rate-perf-considerations.html