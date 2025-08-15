namespace projeto_compiler.CustomListeners;

public class LangDefCustomListener : LangDefBaseListener
{

    public override void EnterStart(LangDefParser.StartContext context)
    {
        double result = AvaliarExpression(context.expression());
        Console.WriteLine(" " + result);
    }

    private double AvaliarExpression(LangDefParser.ExpressionContext context)
    {
        double result = AvaliarTerm(context.term(0));
        for (int i = 1; i < context.term().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText(); // '+' or '-'
            double value = AvaliarTerm(context.term(i));
            result = op switch
            {
                "+" => result + value,
                "-" => result - value,
                _ => throw new Exception("Operador inválido")
            };
        }

        return result;
    }

    private double AvaliarTerm(LangDefParser.TermContext context)
    {
        double result = AvaliarFactor(context.factor(0));
        for (int i = 1; i < context.factor().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText(); // '*' or '/'
            double value = AvaliarFactor(context.factor(i));
            result = op switch
            {
                "*" => result * value,
                "/" => value == 0 ? throw new DivideByZeroException("Divisao por zero.") : result / value,
                _ => throw new Exception("Operador inválido")
            };
        }

        return result;
    }

    private double AvaliarFactor(LangDefParser.FactorContext context)
    {
        if (context.NUMBER() != null)
        {
            return double.Parse(context.NUMBER().GetText(), System.Globalization.CultureInfo.InvariantCulture);
        }
        else if (context.expression() != null)
        {
            // Expressao com parentesis
            return AvaliarExpression(context.expression());
        }
        else
        {
            throw new Exception("Fator inválido");
        }
    }
}