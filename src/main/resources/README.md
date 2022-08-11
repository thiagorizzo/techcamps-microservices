# Criar JAR (skipping test)
- mvn `-Dmaven.test.skip=true package

# Copiar Dockerfile para diretório target com .jar

# Buildar imagem docker
- docker build . -t thiagorizzo/meu-app-spring

# Executar imagem docker
- docker run -p 8181:8080 -t thiagorizzo/meu-app-spring

# Publicar imagen no Docker Hub
- docker login
- docker push thiagorizzo/meu-app-spring

# Kubernetes deployment manifest

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: meu-app-spring
  labels:
    app: meu-app-spring
spec:
  replicas: 3
  selector:
    matchLabels:
      app: meu-app-spring
  template:
    metadata:
      labels:
        app: meu-app-spring
    spec:
      containers:
        - name: meu-app-spring
          image: thiagorizzo/meu-app-spring:latest
          ports:
            - containerPort: 8080
```

- kubectl apply -f .\deployment.yml

# Kubernetes nodeport manifest

```yaml
apiVersion: v1
kind: Service
metadata:
  name: meu-app-spring-service
spec:
  type: NodePort
  selector:
    app: meu-app-spring
  ports:
    - port: 8080
      targetPort: 8080
      nodePort: 30008
```
- kubectl apply -f .\nodeport.yml

- http://<node ip>:3008/cliente
- http://192.168.139.16:30008/cliente

# Rollout

- kubectl rollout history deployments/meu-app-spring

# Rollout de uma versão

- kubectl rollout undo deployments/meu-app-spring

# Rollout para revision específica

- kubectl rollout history deployments/meu-app-spring --revision=1

