package Main;


import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * Created by kingwen on 2017/4/13.
 */
public class Hellohibernate {
    public static void main (String args[]){

        ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure().build();
        MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
        export.create(true, true);

    }
}
