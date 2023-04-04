package cc.procon.common.utils;


import cc.procon.common.vo.FrameTreeVO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * list生成树结构
 *
 * @author procon
 * @since 2023-03-14
 */
public class TreeUtils {
    /**
     * 根据所有树节点列表，生成含有所有树形结构的列表
     *
     * @param nodes 树形节点列表
     * @return 树形结构列表
     */
    @SuppressWarnings("all")
    public static <T extends FrameTreeVO> List<T> generateTrees(List<T> nodes) {
        List<T> result = new ArrayList<>();
        Map<Object, T> id2Node = new LinkedHashMap<>(Math.max((int) (nodes.size() / .75f) + 1, 16));
        nodes.forEach(e -> id2Node.put(e.getId(), e));
        id2Node.forEach((id, node) -> {
            T parentNode = id2Node.get(node.getPid());
            //不是根节点，将node作为子节点添加到对应的父亲节点
            if (parentNode != null) {
                List children = parentNode.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                    parentNode.setChildren(children);
                }
                children.add(node);
            } else {

                result.add(node);
            }
        });
        //移除不是跟根节点
        result.removeIf(e-> !"0".equalsIgnoreCase(e.getPid()));
        return result;
    }
}
