package interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArticleService {

    static List<Article> ARTICLES = List.of(
            new Article(1, 456, 20, 100),
            new Article(2, 4567, 250, 100),
            new Article(1, 456, 20, 100),
            new Article(3, 535, 577, 20),
            new Article(3, 535, 577, 20),
            new Article(3, 123, 235, 300),
            new Article(1, 5678, 20, 350),
            new Article(2, 8654, 9, 5)
    );

    /**
     * 1. Write function that returns articles with given product codes.
     */
    public static List<Article> getArticlesWithProductCode(Set<Integer> productCodes) {
        return ARTICLES.stream().filter(article -> productCodes.contains(article.getProductCode())).collect(Collectors.toList());
    }

    /**
     * 2. Write a function that returns a map of unique articles grouped by product code.
     */
    public static Map getUniqueArticlesGroupedByProductCode() {
        List<Article> articlesList = ARTICLES;
        HashMap<Integer, List<Article>> map = new HashMap<>();

        for (Article article : articlesList) {
            if (!map.containsKey(article.getProductCode())) {
                map.put(article.getProductCode(), articlesList);
            }
        }

        return map;
    }

    public static void main(String[] args) {
//        Set<Integer> productCodes = new HashSet<>();
//        productCodes.add(1);
//        System.out.println(getArticlesWithProductCode(productCodes));

        //first level grouping -> виведе всі артікли з значенням коду який передамо
        Map<Integer, List<Article>> mapGroupedByProductCode = ARTICLES.stream().collect(Collectors.groupingBy(Article::getProductCode));
       System.out.println(mapGroupedByProductCode.get(2));

        //second level grouping -> виведе всі артікли з значенням коду та моделі які передамо
        Map<Integer, Map<Integer, List<Article>>> mapGroupedByCodeAndModel = ARTICLES.stream()
                .collect(Collectors.groupingBy(Article::getProductCode,
                        Collectors.groupingBy(Article::getModel)));
        System.out.println(mapGroupedByCodeAndModel.get(1).get(456));
    }
}

class Article {
    private final Integer productCode;
    private final Integer model;
    private final Integer quality;
    private final Integer color;

    public Article(Integer productId, Integer model, Integer quality, Integer color) {
        this.productCode = productId;
        this.model = model;
        this.quality = quality;
        this.color = color;
    }

    /**
     * -------------------------------------------------------------------------
     * P – product code (1 digit reserved) M – model (4 digits reserved)
     * Q – quality (3 digits reserved)
     * C – color (3 digits reserved)
     * format: PMMMMQQQCCC
     * -------------------------------------------------------------------------
     * productCode = 2, model = 233, quality = 330, color = 400 -> 20233330400
     * productCode = 1, model = 233, quality = 330, color = 2 ->   10233330002
     * productCode = 0, model = 2525, quality = 1, color = 20 ->   02525001020
     * ------------------------------------------------------------------------
     */
    public String toBarcode() {
        return productCode.toString() + model.toString() + quality.toString() + color.toString();
    }

    @Override
    public String toString() {
        return "Article{" +
                "productCode=" + productCode +
                ", model=" + model +
                ", quality=" + quality +
                ", color=" + color +
                '}';
    }

    public Integer getProductCode() {
        return productCode;
    }

    public Integer getModel() {
        return model;
    }

    public Integer getQuality() {
        return quality;
    }

    public Integer getColor() {
        return color;
    }
}
