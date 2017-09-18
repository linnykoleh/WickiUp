### Simple Notification Service (SNS)

Amazon Simple Notification Service (Amazon SNS) is a web service that makes it easy to set up, operate, and send notification from the cloud

It provides developers with a highly scalable, flexible, and cost-effective capability to publish messages from an applications
and immediately deliver then to subscribers or other applications.

Amazon SNS follows the "publish-subscribe" (pub-sub) messaging paradigm, with notifications being delivered to clients 
using a "push" mechanism that eliminates the need to periodically check or " poll" for new information and updates.

With simple APIs requiring minimal up-front development effort, no maintenance or management overhead and pay-as-you-go pricing,
Amazon SNS gives developers an easy mechanism to incorporate a powerful notification system with their applications.

Push notifications to Apple, Google, Fire OS, and Windows devices, as well as Android devices in China with Baidu Cloud Push.

Besides pushing cloud notification directly to mobile devices, Amazon SNS also deliver notifications by SMS test messages or email, 
to Amazon Simple Queue Service (SQS) queues, or to any HTTp endpoint.

To prevent messages from being lost, all messages publishing to Amazon SNS are stored redundantly across multiple availability zones.

**SNS Topics**
SNS allows you to group multiple recipients using topics. A topic is an "access point" for allowing recipients to dynamically 
subscribe for identical copies of the same notification.

One topic can support deliveries to multiple endpoint types - for example, you can group together iOS, Android and SMS recipients.
When you publish once to a topic, SNS delivers appropriate formatted copies of your messages to each subscriber.

**SNS Benefits**
- Instantaneous, push - based delivery (no poling)
- Simple APIs and easy integration wth applications
- Flexible messages delivery over multiple transport protocols
- Inexpensive, pay-as-you-go model with no up-front costs
- Web-based AWS Management Console offers the simplicity of a point-and-click interface

**SNS vs SQS**
- Both Messaging Services in AWS
- SNS - ush
- SQS - Polls (Pulls)

**SNS Pricing**
- Users pay $0.50 per 1 million Amazon SNS Request
- $0.60 per 100,000 Notification deliveries over HTTP
- $0.75 per 100 Notification deliveries oer SMS
- $2.00 per 100,000 Notification deliveries over Email
