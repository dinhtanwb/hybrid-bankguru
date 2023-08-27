package utilities;

import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;

@Sources({"file:environmentConfig/${env}.properties"})
//@Sources({"classpath:dev.properties"})

public interface Environment extends Config{
	String url();
	
	@Key("db.url")
	String dbUrl();
	
	@Key("db.username")
	String dbUserName();
	
	@Key("db.password")
	String dbPassword();
}
