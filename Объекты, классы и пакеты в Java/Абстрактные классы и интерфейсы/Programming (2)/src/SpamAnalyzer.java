class SpamAnalyzer extends KeywordAnalyzer{

    private final String[] keywords;
    private static Label label = Label.SPAM;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }
}
