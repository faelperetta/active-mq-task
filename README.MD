# MESSAGING - ActiveMQ Task

## Prerequisites
Run ActiveMQ using the docker-compose provided in the root directory of the project
```bash
    docker-compose up
```

## Practical Task
1. Implement publish/subscribe interaction between two applications. Check
durable vs non-durable subscription.

    ### How to execute
    ```bash
    curl http://localhost:8080/orders\?order\=new-order
    ```

2. Implement request-reply interaction between two applications using a
temporary queue in ActiveMQ

    ### How to execute
    ```bash
    curl http://localhost:8080/converter\?text\=convert_to_uppercase
    ```
2. Implement subscriber scaling, i.e. create n subscribers to a topic with the
same ClientID (see Virtual Topics in ActiveMQ)

    ### How to execute
    ```bash
    curl http://localhost:8080/virtual\?order\=new-order
    ```
    