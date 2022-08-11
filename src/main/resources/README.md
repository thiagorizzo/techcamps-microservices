# Criar JAR (skipping test)
- ```mvn `-Dmaven.test.skip=true package```

# Copiar Dockerfile para diretório target com .jar

# Buildar imagem docker

Incluir tag de versão, no exemplo `:1`

- `docker build . -t thiagorizzo/meu-app-spring:1`

# Executar imagem docker
 
Forwarding de porta de 80 para porta 8080 no container

- `docker run -p 80:8080 -t thiagorizzo/meu-app-spring:1`

# Publicar imagen no Docker Hub
- `docker login`
- `docker push thiagorizzo/meu-app-spring:1`

# Kubernetes deployment manifest

Deve especificar qual tag de versão utilizar no container em `image`

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
          image: thiagorizzo/meu-app-spring:1
          ports:
            - containerPort: 8080
```

- kubectl apply -f .\deployment.yml

# Kubernetes nodeport manifest

Cria forma de acesso externo através de uma porta específica, no caso, porta 30008.
Nesse caso, requisições a qualquer um node do cluster que possuam a porta destino 30008
serão direcionadas ao service `meu-app-spring` na porta 8080.


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
- `kubectl apply -f .\nodeport.yml`


- http://IP_DE_QUALQUER_NODE:30008/cliente
- http://192.168.139.16:30008/cliente

# Rollout

Apresenta histórico de revisões do deployment

- `kubectl rollout history deployments/meu-app-spring`

# Rollout para revision anterior

- `kubectl rollout undo deployments/meu-app-spring`

# Rollout para revision específica

- ` kubectl rollout history deployments/meu-app-spring --revision=1`

