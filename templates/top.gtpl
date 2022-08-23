<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
    <style type="text/css">
        th,
        td {
            border: solid 1px;
        }

        table {
            border-collapse: collapse;
            /*
            width: 100%;
            */
        }
    </style>
</head>

<body>
    <h2>{{ .Title }}</h2>
    <br>
    <table>
        <tr style="text-align: center">
            <td>イベント名</td>
            <td>ルーム名(ルームID)</td>
            <td>順位</td>
            <td>ポイント</td>
            <td>次順位との差</td>
        </tr>
        {{ $oen := "" }}
        {{ range .PointAndRank }}
        <tr>
            <td>
                {{ if eq .Eventname "" }}
                　** イベントに参加していません **
                {{ else }}
                {{ if ne $oen .Eventname }}
                {{ .Eventname }}
                {{ end }}
                {{ end }}
                {{ $oen = .Eventname }}
            </td>

            <td>　　　({{ .Roomid }})</td>

            {{ if eq .Eventname "" }}
            <td></td>
            <td></td>
            <td></td>
            {{ else }}
            <td style="text-align: right">
                {{ if ne .Rank -1}}
                {{ Comma .Rank }}
                {{ end }}
            </td>
            <td style="text-align: right">{{ Comma .Point }}</td>
            <td style="text-align: right">
                {{ if ne .Gap -1}}
                {{ Comma .Gap }}
                {{ end }}
            </td>
            {{ end }}
        </tr>
        {{ end }}
        <tr>
    </table>
    <p>
        ※ イベントにエントリーしていてもイベント開始前は「** イベントに参加していません **」と表示されます。
    </p>
    <p>
        {{ .ErrMsg}}
    </p>
</body>

</html>