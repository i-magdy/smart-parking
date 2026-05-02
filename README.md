graph TB
    %% Direction: Top to Bottom for Mobile Compatibility
    
    subgraph Production ["Production Phase"]
        direction TB
        Gen(["<b>Generator</b>"]):::proc
        Test(["<b>Tester</b>"]):::proc
        Int(["<b>Integrator</b>"]):::proc
    end

    %% Decision Nodes
    Val{"<b>Validator</b>"}:::gate
    Reviewer(["<b>Reviewer</b>"]):::proc
    
    %% Action & Final State Nodes
    Ref(["<b>Refactor</b>"]):::warn
    Pass(("<b>Accepted<br>Artifacts</b>")):::success

    %% Logic Flow
    Gen --> Test
    Gen --> Int
    Test --> Val
    Int --> Val
    
    Val -- "Pass" --> Reviewer
    Reviewer -- "Agree" --> Pass
    
    %% Feedback Loops
    Val -- "Fail" --> Ref
    Reviewer -- "Challenge" --> Ref
    Ref -.-> |Loopback| Gen

    %% Style Definitions (CSS-based)
    classDef proc fill:#2d333b,stroke:#636e7b,stroke-width:2px,color:#adbac7;
    classDef gate fill:#343b41,stroke:#eac54f,stroke-width:2px,color:#adbac7;
    classDef success fill:#22272e,stroke:#44ad4d,stroke-width:3px,color:#adbac7;
    classDef warn fill:#22272e,stroke:#da3633,stroke-width:2px,color:#adbac7;
    classDef default color:#adbac7;

    %% Applying Classes
    class Production fill:#1c2128,stroke:#444c56,stroke-dasharray: 5 5;
