package beans.factory;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    /**
     *存放类中的所有属性
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 增加属性
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    /**
     * get 所有的属性，以array形式输出
     * @return {@link PropertyValue[] }
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 查找propertyName对应的PropertyValue
     * @param propertyName
     * @return {@link PropertyValue }
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue pv = this.propertyValueList.get(i);
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}