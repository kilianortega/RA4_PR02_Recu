public class Magatzem {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int TRIPLE_QUALITY_LIMIT_DAYS = 5;
    private static final int DOUBLE_QUALITY_LIMIT_DAYS = 10;

    private Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (Article article : articles) {
            actualitzarArticle(article);
        }
    }

    private void actualitzarArticle(Article article) {
        if (article.getNom().equals("Martell de Thor")) {
            return;
        }

        article.setDiesPerVendre(article.getDiesPerVendre() - 1);

        switch (article.getNom()) {
            case "Formatge Gidurat":
                actualitzarFormatge(article);
                break;
            case "Entrades per al Concert del T":
                actualitzarEntrades(article);
                break;
            default:
                actualitzarArticleNormal(article);
                break;
        }

        if (article.getQualitat() > MAX_QUALITY) {
            article.setQualitat(MAX_QUALITY);
        }
        if (article.getQualitat() < MIN_QUALITY) {
            article.setQualitat(MIN_QUALITY);
        }
    }

    private void actualitzarFormatge(Article article) {
        article.setQualitat(article.getQualitat() + 1);
        if (article.getDiesPerVendre() < 0) {
            article.setQualitat(article.getQualitat() + 1);
        }
    }

    private void actualitzarEntrades(Article article) {
        if (article.getDiesPerVendre() < 0) {
            article.setQualitat(MIN_QUALITY);
        } else if (article.getDiesPerVendre() <= TRIPLE_QUALITY_LIMIT_DAYS) {
            article.setQualitat(article.getQualitat() + 3);
        } else if (article.getDiesPerVendre() <= DOUBLE_QUALITY_LIMIT_DAYS) {
            article.setQualitat(article.getQualitat() + 2);
        } else {
            article.setQualitat(article.getQualitat() + 1);
        }
    }

    private void actualitzarArticleNormal(Article article) {
        article.setQualitat(article.getQualitat() - 1);
        if (article.getDiesPerVendre() < 0) {
            article.setQualitat(article.getQualitat() - 1);
        }
    }
}

class Article {
    private String nom;
    private int diesPerVendre;
    private int qualitat;

    public Article(String nom, int diesPerVendre, int qualitat) {
        this.nom = nom;
        this.diesPerVendre = diesPerVendre;
        this.qualitat = qualitat;
    }

    public String getNom() {
        return nom;
    }

    public int getDiesPerVendre() {
        return diesPerVendre;
    }

    public void setDiesPerVendre(int diesPerVendre) {
        this.diesPerVendre = diesPerVendre;
    }

    public int getQualitat() {
        return qualitat;
    }

    public void setQualitat(int qualitat) {
        this.qualitat = qualitat;
    }
}