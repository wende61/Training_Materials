FROM icr.io/appcafe/open-liberty:full-java17-openj9-ubi

ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_USER postgres

COPY src/main/liberty/config/server.xml /config/server.xml
COPY --chown=1001:0  src/main/liberty/config/postgresql-42.2.8.jar /config/
COPY target/liberty/wlp/usr/shared/resources/jdbc/postgresql-42.2.5.jar /opt/ol/wlp/usr/shared/resources/jdbc/
COPY target/jakartaee-hello-world.war /config/apps/
