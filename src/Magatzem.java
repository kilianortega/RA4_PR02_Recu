public class Magatzem {
    private Article[] articles;
    
    // PATRÓN: Replace Magic Number with Symbolic Constant
    private static final int QUALITAT_MAXIMA = 50;
    private static final int QUALITAT_MINIMA = 0;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (Article article : articles) {
            actualitzarArticle(article);
        }
    }

    private void actualitzarArticle(Article article) {
        if (article.nom.equals("Martell de Thor (Llegendari)")) {
            return; 
        }

        article.diesPerVendre--;

        switch (article.nom) {
            case "Formatge Gidurat":
                actualitzarFormatge(article);
                break;
            case "Entrades per al Concert del Trobador":
                actualitzarEntrades(article);
                break;
            default:
                actualitzarArticleNormal(article);
                break;
        }

        if (article.qualitat > QUALITAT_MAXIMA) article.qualitat = QUALITAT_MAXIMA;
        if (article.qualitat < QUALITAT_MINIMA) article.qualitat = QUALITAT_MINIMA;
    }

    private void actualitzarFormatge(Article article) {
        article.qualitat++;
        if (article.diesPerVendre < 0) {
            article.qualitat++;
        }
    }

    private void actualitzarEntrades(Article article) {
        if (article.diesPerVendre < 0) {
            article.qualitat = 0;
        } else if (article.diesPerVendre <= 5) {
            article.qualitat += 3;
        } else if (article.diesPerVendre <= 10) {
            article.qualitat += 2;
        } else {
            article.qualitat += 1;
        }
    }

    private void actualitzarArticleNormal(Article article) {
        article.qualitat--;
        if (article.diesPerVendre < 0) {
            article.qualitat--;
        }
    }
}

class Article {
    public String nom;
    public int diesPerVendre;
    public int qualitat;

    public Article(String nom, int diesPerVendre, int qualitat) {
        this.nom = nom;
        this.diesPerVendre = diesPerVendre;
        this.qualitat = qualitat;
    }
}