

![Bash](../images/EC2/bash.png)

#!/bin/bash
yum update -y
yum install httpd -y
service httpd start
chkconfig httpd on
aws s3 cp s3://linnykwebsitebucket/index.html /var/www/html