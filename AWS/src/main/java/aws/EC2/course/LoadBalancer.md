
#### Elastic Load Balancer

Elastic Load Balancer to load balance the traffic between these instances. 

![ec2_from_off_docs](../../images/EC2/load_balancer.png)

![ec2_from_off_docs](../../images/EC2/load_balancer_aws.png)

![ec2_from_off_docs](../../images/EC2/load_balancer_aws_1.png)

![ec2_from_off_docs](../../images/EC2/load_balancer_aws_2.png)

![ec2_from_off_docs](../../images/EC2/load_balancer_aws_3.png)

![ec2_from_off_docs](../../images/EC2/load_balancer_aws_4.png)


 - Instances monitored by ELB are reported as:
 	- InService
 	- OutOfService
 - Health checks check the instance health by talking to it
 - Have their own DNS name. You are never given an IP address
 - Read the ELB FAQ for Classic Load Balancer