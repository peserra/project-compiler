using System;
using Antlr4.Runtime.Misc;
namespace projeto_compiler.CustomListeners; // ou o namespace dos arquivos gerados

public class LangDefCustomListener : LangDefBaseListener
{
    
    private Dictionary<string, double> variaveis = new();

    // Avalia uma expressão recursivamente
    private double AvaliarExpr(LangDefParser.ExprContext context)
    {
        double resultado = AvaliarTerm(context.term(0));
        for (int i = 1; i < context.term().Length; i++)
        {
            var operador = context.OPERATOR(i - 1).GetText();
            var valor = AvaliarTerm(context.term(i));
            resultado = operador switch
            {
                "+" => resultado + valor,
                "-" => resultado - valor,
                "*" => resultado * valor,
                "/" => resultado / valor,
                _ => resultado
            };
        }
        return resultado;
    }

    private double AvaliarTerm(LangDefParser.TermContext context)
    {
        if (context.ID() != null)
        {
            var nome = context.ID().GetText();
            if (variaveis.TryGetValue(nome, out double valor))
                return valor;
            else
                throw new Exception($"Variável '{nome}' não definida.");
        }
        else if (context.NUMBER() != null)
        {
            return double.Parse(context.NUMBER().GetText());
        }
        throw new Exception("Termo inválido.");
    }

    public override void EnterCmdAttr(LangDefParser.CmdAttrContext context)
    {
        var nome = context.ID().GetText();
        var valor = AvaliarExpr(context.expr());
        variaveis[nome] = valor;
        Console.WriteLine($"Atribuição: {nome} = {valor}");
    }

    public override void EnterCmdWrite(LangDefParser.CmdWriteContext context)
    {
        var nome = context.ID().GetText();
        if (variaveis.TryGetValue(nome, out double valor))
            Console.WriteLine(valor);
        else
            Console.WriteLine($"Variável '{nome}' não definida.");
    }
}