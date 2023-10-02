# Use a imagem Alpine Linux como base
FROM alpine

# Defina a versão do Java que você deseja usar
ENV JAVA_VERSION=17

# Defina o diretório de instalação do JDK
ENV JDK_HOME=/opt/jdk-$JAVA_VERSION

# Crie um diretório de trabalho para a aplicação
WORKDIR /app

# Atualize os pacotes do sistema e instale as dependências necessárias
RUN apk update && \
    apk add --no-cache openjdk$JAVA_VERSION

# Adicione o diretório bin do JDK ao PATH
ENV PATH=$JDK_HOME/bin:$PATH

ENV SPRING_PROFILES_ACTIVE=prod

# Copie os arquivos da aplicação para o diretório de trabalho
COPY ./target/spring-with-mysql-0.0.1-SNAPSHOT.jar .

# Comando para executar a aplicação Java
CMD ["java", "-jar", "spring-with-mysql-0.0.1-SNAPSHOT.jar"]
