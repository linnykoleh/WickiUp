CLI - Command Line

Define user who has access to EC2 through CLI.
Mostly have to be used when connecting outside.

- `aws s3 help` - help
- `aws configure` - configuring access
	- Enter `AWS Access Key ID`
	- Enter `AWS Secret Access Key`
	- Enter `Default region name`
	- Enter `Default output format`
- `aws s3 ls` - see all buckets
- All configuring is saving on `~/.aws/credentials`
- `aws ec2 describe-instances` - describing all instances
- `aws ec2 terminate-instances --instance-ids InstanceId` - terminate instance by instance Id
- `aws s3 cp --recursive s3://s3-bucket-name /home/ec2-user/` - download data from bucket to ec2
- `aws s3 cp --recursive s3://acloudguru-linnyk-22-nv /home/ec2-user/ --region eu-west-2` - download data from bucket to ec2 with region 