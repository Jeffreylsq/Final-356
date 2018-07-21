public class Analysis implements NodeVisitor {

    public Analysis(){}

    @Override
    public int visit(User user) {
        return user.getFeed().size();
    }

    @Override
    public int visit(Group group) {
        return 1;
    }
}