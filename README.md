graph TB
    %% اتجاه Top → Bottom (مناسب للموبايل)

    %% =========================
    %% PHASE 1: GENERATION
    %% =========================
    subgraph P1 ["Phase 1: Generation"]
        direction TB
        Gen(["<b>Generator</b><br/>Produces Artifacts"]):::proc
    end

    %% =========================
    %% PHASE 2: PROCESSING
    %% =========================
    subgraph P2 ["Phase 2: Processing"]
        direction TB
        Test(["<b>Tester</b><br/>Validates Behavior"]):::proc
        Int(["<b>Integrator</b><br/>Ensures Consistency"]):::proc
    end

    %% =========================
    %% PHASE 3: VALIDATION
    %% =========================
    subgraph P3 ["Phase 3: Validation"]
        direction TB
        Val{"<b>Validator</b><br/>Quality Gate"}:::gate
    end

    %% =========================
    %% PHASE 4: REVIEW
    %% =========================
    subgraph P4 ["Phase 4: Review"]
        direction TB
        Reviewer(["<b>Reviewer</b><br/>Human / AI Oversight"]):::proc
    end

    %% =========================
    %% TERMINAL STATES
    %% =========================
    Pass(("<b>Accepted<br/>Artifacts</b>")):::success
    Ref(["<b>Refactor</b><br/>Feedback Loop"]):::warn

    %% =========================
    %% MAIN FLOW
    %% =========================
    Gen -->|Artifacts| Test
    Gen -->|Artifacts| Int

    Test -->|Test Results| Val
    Int -->|Integration Report| Val

    Val -- "Pass" --> Reviewer
    Val -- "Fail" --> Ref

    Reviewer -- "Approve" --> Pass
    Reviewer -- "Request Changes" --> Ref

    %% =========================
    %% FEEDBACK LOOP
    %% =========================
    Ref -.->|Refinement Cycle| Gen

    %% =========================
    %% OPTIONAL PARALLEL HINT
    %% =========================
    note1["Tester & Integrator run in parallel"]:::note
    Gen -.-> note1

    %% =========================
    %% STYLES
    %% =========================
    classDef proc fill:#2d333b,stroke:#636e7b,stroke-width:2px,color:#adbac7;
    classDef gate fill:#343b41,stroke:#eac54f,stroke-width:2px,color:#adbac7;
    classDef success fill:#1f6f43,stroke:#44ad4d,stroke-width:3px,color:#d1f5d3;
    classDef warn fill:#3a1f1f,stroke:#da3633,stroke-width:2px,color:#f5c2c0;
    classDef note fill:#1c2128,stroke:#444c56,stroke-dasharray: 3 3,color:#8b949e;

    class P1,P2,P3,P4 fill:#1c2128,stroke:#444c56,stroke-dasharray: 5 5;
