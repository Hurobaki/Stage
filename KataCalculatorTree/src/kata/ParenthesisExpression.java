package kata;

public class ParenthesisExpression extends UnaryExpression {

	public ParenthesisExpression(Expression expression) {
		// TODO Auto-generated constructor stub
		super(expression);
	}

	@Override
	public Double eval() {
		// TODO Auto-generated method stub
		return getExpression().eval();
	}

}
