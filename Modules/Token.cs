using System.Dynamic;

namespace projeto_compiler;

public enum TokenTypes
{
    IDENTIFIER,
    NUMBER,
    OPERATOR,
    PUNCTUATION,
    ASSIGN,
}

public class Token
{
    public TokenTypes Type { get; private set; }
    public string Text { get; private set; }

    public Token()
    {

    }
    public Token(TokenTypes type, string text)
    {
        Type = type;
        Text = text;
    }

    public override string ToString()
    {
        return $"Token [type={Type}, text={Text}]";
    }
}
