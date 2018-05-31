package shiro;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	private String filterChainDefinitions;

	@Override
	public Ini.Section getObject() {
		//获取所有Resource
		//List<Resource> list = resourceDao.getAll();
		Ini ini = new Ini();
		//加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		//循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap
		//里面的键就是链接URL,值就是存在什么条件才能访问该链接
		section.put("/shiro/addPermission", "perms[add3]");
		section.put("/shiro/deletePermission", "perms[delete2]");
		return section;
	}

	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	@Override
	public Class<?> getObjectType() {
		return this.getClass();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
