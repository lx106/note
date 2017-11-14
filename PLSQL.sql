# Oracle 循环装数存储过程
declare 
 err_exception exception;
 v_start_dt date;
 v_end_dt date;
 o_logcod varchar2(200);
 o_logdes varchar2(200);
begin
  select min(etl_dt) into v_start_dt from H_XXX_S;
  select max(etl_dt) into v_end_dt from H_XXX_S;
  
  while v_start_dt <= v_end_dt loop
    
    P_H_XXX_H(v_start_dt,o_logcod,o_logdes);
    if o_logcod <> 0 then
      raise err_exception;
    end if;
    v_start_dt := v_start_dt + 1;
  end loop;
end;      