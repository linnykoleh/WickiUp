### Security Group 
Security Group is a Virtual Firewall
It's controlling traffic to your instances
1 instance can have multiple security groups.

- Any rule you make to Security Group applies `immediately`
- Security Group is stateful. Everything that you added into `InBound` will automatically add to `OutBound`
- You can denied traffic by Security Group
- All Inbound traffic is Blocked By default
- All OutBound traffic is Allowed
- Changes to Security Groups take effect immediately
- You can have any number of EC2 instances within a security group
- You can have multiple security groups attached to EC2 instances
- Security Groups are STATEFUL
	- If you create an inbound rule allowing traffic in,  that traffic is automatically allowed back out again
- You can not block specific IP addresses using Security Groups instead use Network Access Control Lists
- You can specify allow rules, but not deny rules
