abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.lastIndexOf(keyword)!=-1) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
