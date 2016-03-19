# cljs-lambda-slack-command

Minimal template for writing [Clojurescript AWS Lambda
functions](https://github.com/nervous-systems/cljs-lambda), which, when exposed
via [Amazon's API Gateway](https://aws.amazon.com/api-gateway/), can serve as
backends for [Slash Commands](https://api.slack.com/slash-commands) in Slack.

```bash
$ lein new cljs-lambda-slack-command echo [+slack-token abcdef]
```

See the generated README for deployment instructions.  The `create-api.sh` shell
script (in the project's root directory) can be used to expose the deployed
function via an API Gateway endpoint suitable for giving to Slack.
