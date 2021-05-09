// 声明文件名
// 后续生成的Java文件，也会根据这个命名
grammar Calculate;

execute : symbol+;

symbol
    : assignmentSymbol  // 赋值符号
    | conditionSymbol   // 条件符号
    | evaluationSymbol  // 求值符号
    | SymbolNewLine
    ;

// 条件声明
conditionSymbol : '如果'  expression symbol;

// 赋值符号
assignmentSymbol : Variable '=' expression SymbolNewLine;

// 求值声明
evaluationSymbol : expression SymbolNewLine;

// 表达式
expression : beEqualsExpression;

// 等同判断表达式
beEqualsExpression
    : compareExpression
    | beEqualsExpression '==' compareExpression
    | beEqualsExpression '为' compareExpression
    | beEqualsExpression '!=' compareExpression
    | beEqualsExpression '≠' compareExpression
    | beEqualsExpression '&&' compareExpression
    | beEqualsExpression '||' compareExpression
    ;

// 比较表达式
compareExpression
    : summationExpression
    | compareExpression '<' summationExpression
    | compareExpression '>' summationExpression
    | compareExpression '<=' summationExpression
    | compareExpression '>=' summationExpression
    | compareExpression '≤' summationExpression
    | compareExpression '≥' summationExpression
    ;

// 求和表达式
summationExpression
    : quadratureExpression
    | summationExpression '+' quadratureExpression
    | summationExpression '-' quadratureExpression
    ;

// 求积表达式
quadratureExpression
    : minimumExpression
    | quadratureExpression '*' minimumExpression
    | quadratureExpression '×' minimumExpression
    | quadratureExpression '/' minimumExpression
    | quadratureExpression '÷' minimumExpression
    ;

// 最小表达式
minimumExpression
    : literalExpression
    | '(' expression ')'
    ;

// 字面量
literalExpression
    : Numerical
    | Variable
    ;

// 变量
Variable : ('a' .. 'z' | 'A' .. 'Z')+;

// 数值
Numerical : [0-9]+[.]?[0-9]*;
//Numerical : [0-9]+;

SymbolAdd : '+';
SymbolSubtract : '-';
SymbolProcedureMultiply : '*';
SymbolMultiply : '×';
SymbolProcedureDivide : '/';
SymbolDivide : '÷';

SymbolWei : '为';
SymbolEquals : '==';
// 不等号（程序）
SymbolProcedureNotEquals : '!=';
// 不等号
SymbolNotEquals : '≠';
// and 和
SymbolAnd : '&&';
// or 或
SymbolOr : '||';

// 大于号
SymbolGreater : '>';
// 大于等于号（程序）
SymbolProcedureGreaterEquals : '>=';
// 大于等于号
SymbolGreaterEquals : '≥';

// 小于号
SymbolLess : '<';
// 小于等于号（程序）
SymbolProcedureLessEquals : '<=';
// 小于等于号
SymbolLessEquals : '≤';

// 新行
SymbolNewLine : '\r'?'\n';

// 空格
SymbolBlank: [ ]+ ->skip;


