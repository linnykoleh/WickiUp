### IAM -  Identity Access Management  

https://aws.amazon.com/ru/iam/

> Allows you yo manage users and their level of access to the AWS console. 
> It is important to understand IAM and how it works, both for the exam and for the administrating a company's AWS account in real life

**What does IAM give you**
- Centralised control of your AWS account
- Shared Access to your AWS account
- Granular permission
- Identity Federation (including Active Directory, Facebook, Linkedin) 
- Multi-factor Authentication
- Provide temporary access for users/devices and services where necessary
- Allows you to set up your own password rotation policy
- Integrates with many different AWS services 
- Support PCI DSS Compliance
- IAM consists of the following:
	 - Users
	 - Groups (A way to group our users and apply polices to them collectively) 
	 - Roles
	 - Policy Documents
- IAM is universal. It does not apply to regions at this time 	 
- The `root account` is simply the account created when first setup your AWS account. It has complete Admin access by default
- New Users have NO permissions when first created
- New Users are assigned Access Key ID & Secret Access Keys when first created
- These are not the same as a password, and you cannot use the Access KeyID & Secret Access Key to Login in to the console. You can use this to access AWS via the APIs and Command Line however
- You only get to view these once. If you lose them, you have to regenerate them. So save them in a secure location.
- Always setup Multi-factor Authentication on yur root account
- You can create and customise your own password rotation policies

IAM does not require region election:

![IAM does not require region election](../images/IAM/IAM_not_require_reqion.png)

IAM users sign-in link:

![IAM does not require region election](../images/IAM/IAM_user_link.png)


**Critical Terms**:
- Users - End Users (think people) 
- Groups - A collection of users under one set of permission
- Roles - You create roles and can then assign them to AWS resources
- Policies - A document that defines one or more permissions


**Terms**:
- MFA - multi-factor authentication
- Root account - email for sign up to AWS
- Access key ID and Secret Access key - token would you use in order to programmatically interact with AWS you can't use them to login to AWS console


**Security Token Service (STS)**

Grants users limited and temporary access to AWS resources. Users can come from three sources:
- Federation (typically Active Directory)
	- Uses Security Assertion MarkUp Language (SAML)
	- Grants temporary access based off the users Active Directory credentials. Does not need to be a user in AIM
	- Single sigh on allows users to log in to AWS console without assigning IAM credentials
- Federation with Mobile Apps
	- Use Facebook/Amazon/Google or the OpenID providers to log on
- Cross Account Access
	- Let's users from one AWS account access resources in another 	


**Understanding Key Terms**:
- Federation: combining or joining a list of users in one domain(such as IAM) with a list of users in another domain (such as Active Directory, Facebook, Linkedin etc)
	- Identity Broker: a service that allows you to take an identity from point A and join it (federate it) to point B
	- Identity Store - Services like Active Directory, Facebook, Google etc
	- Identities - a user of a service like Facebook etc


**How it works(have to be on exam)**
1. Develop an Identity Broker to communicate with LDAP and AWS STS
2. Identity Broker always authenticates with LDAP first, THEN with AWS STS
3. Application then gets temporary access to AWS resources 

		
**On exam:**
1. Can you authenticate with active directory?
	- Yes, using SAML
2. What type of authenticate?
	- SAML (security assertion markup language)
3. Whether or not your authenticating to active directory first and then giving a temporal security credential or if you get a temporal security credential first which is then authenticate againt to active directory?
	- You always authenticate to active directory first and then you will be assign security credential
4. What is Arn?
	- Amazon Resource Name
5. Have you to create new role in new region?
	- No, because all roles are global
6. Weather or not is it possible to attach role	to running EC2 instance
	- It is now possible
	
	

**IAM Best practices**	

Enables you to control who can do what in your AWS account

Users, groups, roles and permissions

Control
	- Centralized
	- Fine-grained - APIs, resources, and AWS console
Security
	- Secure by default
	- Multiple users, individual security credentials and permissions