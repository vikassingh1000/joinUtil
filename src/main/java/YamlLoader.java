import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class YamlLoader {

    public <E> E load(Class<E> clzz) {
        Yaml yaml = new Yaml(new Constructor(clzz));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/joinCheckConfig1.yaml");
        return yaml.load(inputStream);
    }

    public static void main(String[] args) {
        YamlLoader yl = new YamlLoader();

        System.out.println(yl.load(JoiningTables.class).toString());
    }
}
